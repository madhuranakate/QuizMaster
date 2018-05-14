
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/madhura/Applications/hmrc-development-environment/hmrc/QuizMaster/conf/routes
// @DATE:Mon May 14 15:35:34 BST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
