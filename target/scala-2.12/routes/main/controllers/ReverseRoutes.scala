
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/madhura/Applications/hmrc-development-environment/hmrc/QuizMaster/conf/routes
// @DATE:Mon May 14 15:35:34 BST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseIndexController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
