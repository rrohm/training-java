/*
 *  This code is released under Creative Commons Attribution 4.0 International
 *  (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 *  That means:
 *
 *  You are free to:
 *
 *      Share — copy and redistribute the material in any medium or format
 *      Adapt — remix, transform, and build upon the material
 *               for any purpose, even commercially.
 *
 *      The licensor cannot revoke these freedoms as long as you follow the
 *      license terms.
 *
 *  Under the following terms:
 *
 *      Attribution — You must give appropriate credit, provide a link to the
 *      license, and indicate if changes were made. You may do so in any
 *      reasonable manner, but not in any way that suggests the licensor endorses
 *      you or your use.
 *
 *  No additional restrictions — You may not apply legal terms or technological
 *  measures that legally restrict others from doing anything the license
 *  permits.
 *
 *
 *  2015 Aeonium Software Systems, Robert Rohm.
 */

package org.meins.sicherheit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.util.Arrays;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class Auth {

  public static void main(String[] args) {

    // Login über JAAS LoginContext
    LoginContext lc = null;
    try {
      // Wichtig: LoginContext mit eigenem Callback-Handler erzeugen.
      lc = new LoginContext("Meins", new MyCallbackHandler());

    } catch (LoginException le) {
      System.err.println("Cannot create LoginContext. " + le.getMessage());
      System.exit(-1);
    } catch (SecurityException se) {
      System.err.println("Cannot create LoginContext. " + se.getMessage());
      System.exit(-1);
    }

    // the user has 3 attempts to authenticate successfully
    int i;
    for (i = 0; i < 3; i++) {
      try {

        // attempt authentication
        lc.login();

        // if we return with no exception, authentication succeeded
        break;

      } catch (LoginException le) {

        System.err.println("Authentication failed:");
        System.err.println("  " + le.getMessage());
        try {
          Thread.currentThread().sleep(3000);
        } catch (Exception e) {
          // todo: error handling
        }

      }
    }

    // did they fail three times?
    if (i == 3) {
      System.out.println("Sorry");
      System.exit(-1);
    }

    System.out.println("Authentication succeeded!");
  }
}

class MyCallbackHandler implements CallbackHandler {

  /**
   * Invoke an array of Callbacks.
   *
   * <p>
   *
   * @param callbacks an array of <code>Callback</code> objects which contain
   * the information requested by an underlying security service to be retrieved
   * or displayed.
   *
   * @exception java.io.IOException if an input or output error occurs.
   * <p>
   *
   * @exception UnsupportedCallbackException if the implementation of this
   * method does not support one or more of the Callbacks specified in the
   * <code>callbacks</code> parameter.
   */
  @Override
  public void handle(Callback[] callbacks) throws IOException,
          UnsupportedCallbackException {

    for (int i = 0; i < callbacks.length; i++) {
      if (callbacks[i] instanceof TextOutputCallback) {

        // display the message according to the specified type
        TextOutputCallback toc = (TextOutputCallback) callbacks[i];
        switch (toc.getMessageType()) {
          case TextOutputCallback.INFORMATION:
            System.out.println(toc.getMessage());
            break;
          case TextOutputCallback.ERROR:
            System.out.println("ERROR: " + toc.getMessage());
            break;
          case TextOutputCallback.WARNING:
            System.out.println("WARNING: " + toc.getMessage());
            break;
          default:
            throw new IOException("Unsupported message type: "
                    + toc.getMessageType());
        }

      } else if (callbacks[i] instanceof NameCallback) {

        // prompt the user for a username
        NameCallback nc = (NameCallback) callbacks[i];

        System.err.print(nc.getPrompt());
        System.err.flush();
        nc.setName((new BufferedReader(new InputStreamReader(System.in)))
                .readLine());

      } else if (callbacks[i] instanceof PasswordCallback) {

        // prompt the user for sensitive information
        PasswordCallback pc = (PasswordCallback) callbacks[i];
        System.err.print(pc.getPrompt());
        System.err.flush();
        pc.setPassword(readPassword(System.in));

      } else {
        throw new UnsupportedCallbackException(callbacks[i],
                "Unrecognized Callback");
      }
    }
  }

  // Reads user password from given input stream.
  private char[] readPassword(InputStream in) throws IOException {

    char[] lineBuffer;
    char[] buf;
    int i;

    buf = lineBuffer = new char[128];

    int room = buf.length;
    int offset = 0;
    int c;

    loop:
    while (true) {
      switch (c = in.read()) {
        case -1:
        case '\n':
          break loop;

        case '\r':
          int c2 = in.read();
          if ((c2 != '\n') && (c2 != -1)) {
            if (!(in instanceof PushbackInputStream)) {
              in = new PushbackInputStream(in);
            }
            ((PushbackInputStream) in).unread(c2);
          } else {
            break loop;
          }

        default:
          if (--room < 0) {
            buf = new char[offset + 128];
            room = buf.length - offset - 1;
            System.arraycopy(lineBuffer, 0, buf, 0, offset);
            Arrays.fill(lineBuffer, ' ');
            lineBuffer = buf;
          }
          buf[offset++] = (char) c;
          break;
      }
    }

    if (offset == 0) {
      return null;
    }

    char[] ret = new char[offset];
    System.arraycopy(buf, 0, ret, 0, offset);
    Arrays.fill(buf, ' ');

    return ret;
  }
}
