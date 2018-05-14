
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/madhura/Applications/hmrc-development-environment/hmrc/QuizMaster/conf/routes
// @DATE:Mon May 14 15:35:34 BST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseIndexController IndexController = new controllers.ReverseIndexController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseIndexController IndexController = new controllers.javascript.ReverseIndexController(RoutesPrefix.byNamePrefix());
  }

}
