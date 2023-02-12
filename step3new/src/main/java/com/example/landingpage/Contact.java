package com.example.landingpage;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;
import java.util.Date;

/**
 * The @Entity tells Objectify about our entity. We also register it in {@link OfyHelper} Our
 * primary key @Id is set automatically by the Google Cloud Datastore for us.
 *
 * <p>Objectify, unlike the App Engine library requires that you specify the fields you want
 * to index using @Index. Only indexing the fields you need can lead to substantial gains in
 * performance -- though if not indexing your data from the start will require indexing it later.
 */
@Entity
public class Contact {

  @Id
  public Long id;

  @Index
  public String email;
  @Index
  public Date date;

  public Contact(String email) {
    this.date = new Date();
    this.email = email;
  }

}
