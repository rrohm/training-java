/*
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 *  Copyright 2014 AEONIUM SOFTWARE SYSTEMS - ALL RIGHTS RESERVED.
 *
 *  The contents of this file are intellectual property of
 *  Aeonium Software Systems, Robert Rohm. All rights reserved.
 *  You must NOT, especially:
 *  - redistribute this file in source form,
 *  - redistribute this file in binary form,
 *  - modify this file,
 *  - use this file for your own work
 *  WITHOUT WRITTEN PERMISSION.
 *
 *  Anyway, we appreciate any interest in our work and knowledge.
 *  So, if you wish to use this file for your own purposes,
 *  please contact us:
 *  mailto:info@aeonium-systems.de
 *
 *
 *  © 2014 Aeonium Software Systems, Robert Rohm.
 */

$(document).ready(function(){
  $('h5').addClass('dots');
  $("pre").addClass("brush: java");
  SyntaxHighlighter.all();

  $("h4").css("cursor", "pointer").click(function(evt){
    $(this).next().fadeToggle();
  }).next().hide();

  $("h5").css("cursor", "pointer").click(function(evt){
    $(this).toggleClass('dots').next().fadeToggle();
  }).next().hide();
});
