package tadashiy.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

import org.glassfish.jersey.server.mvc.Viewable;
import com.google.gson.Gson;

import tadashiy.entity.Blog;

@Path("blog")
public class BlogRcs {

  private EntityManager em;
  private Gson gson;

  public BlogRcs() {
    EntityManagerFactory fac = Persistence.createEntityManagerFactory("pu");
    this.em = fac.createEntityManager();
    this.gson = new Gson();
  }

  @GET
  public Viewable index() {
    return new Viewable("/index");
  }

  @GET
  @Path("entries")
  public Response entries() {
    final String sql = "SELECT b FROM Blog b ORDER BY b.id DESC";
    final List<Blog> list = this.em.createQuery(sql, Blog.class)
      .getResultList();
    return Response.ok(gson.toJson(list)).build();
  }
}