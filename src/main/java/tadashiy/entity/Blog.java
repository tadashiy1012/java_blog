package tadashiy.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement
public class Blog {
  @Id
  public Integer id;
  @Column
  public String title;
  @Column
  public String body;
  @Column
  public String author;
  @Column
  public Date date;
}