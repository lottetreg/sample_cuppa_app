import io.github.lottetreg.Cuppa.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloWorld {
  public static void main(String[] args) {
    try {
      Server.start(5000, getRoutes()); // rename to Cuppa.serve() ?
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static List<Routable> getRoutes() {
    return new ArrayList<>(Arrays.asList(
        new Route("/simple_get", "GET", ExampleController.class, "empty"),
        new Route("/echo_body", "POST", ExampleController.class, "echo"),
        new Route("/method_options", "GET", ExampleController.class, "empty"),
        new Route("/method_options2", "GET", ExampleController.class, "empty"),
        new Route("/method_options2", "PUT", ExampleController.class, "empty"),
        new Route("/method_options2", "POST", ExampleController.class, "empty"),
        new Route("/pickles", "GET", ExampleController.class, "pickles"),
        new Route("/pickles_with_header", "GET", ExampleController.class, "picklesWithHeader"),
        new Redirect("/redirect", "GET", "/simple_get"),
        new Route("/get_with_body", "HEAD", "", ""), // need this to pass acceptance tests >:(
        new Route("/time", "GET", ExampleController.class, "time"),
        new Route("/something", "GET", SomethingController.class, "something")
    ));
  }
}
