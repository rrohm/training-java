#!/usr/bin/jjs -fv
//
// Scripting with Nashorn, turned on with option -scription or with # as first char.
// see https://docs.oracle.com/javase/8/docs/technotes/guides/scripting/nashorn/shell.html
//
// Usage: ./scriptArgs.js -- arg1 arg2 argn

print('Arguments: ' + arguments);

// Global Objects: 
print('ARGS: ' + $ARG);
print('Options: ' + JSON.stringify($OPTIONS));
print('ENV:  ' + JSON.stringify($ENV));

// Execution of commands in a new process: 
$EXEC('ls -l');
print('Output from EXEC: ' + $OUT);
print('Exit code       : ' + $EXIT);

exit();
