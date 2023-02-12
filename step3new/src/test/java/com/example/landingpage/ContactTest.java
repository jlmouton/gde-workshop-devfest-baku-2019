package com.example.landingpage;

import static org.junit.Assert.assertEquals;



import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.Closeable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class ContactTest {

  private static final String TEST_EMAIL = "test@test.com";

  private final LocalServiceTestHelper helper =
      new LocalServiceTestHelper(
          // Set no eventual consistency, that way queries return all results.
          // https://cloud.google
          // .com/appengine/docs/java/tools/localunittesting
          // #Java_Writing_High_Replication_Datastore_tests
          new LocalDatastoreServiceTestConfig()
              .setDefaultHighRepJobPolicyUnappliedJobPercentage(0));

  private Closeable closeable;
  private DatastoreService ds;

  @Before
  public void setUp() throws Exception {

    helper.setUp();
    ds = DatastoreServiceFactory.getDatastoreService();

    ObjectifyService.register(Contact.class);

    closeable = ObjectifyService.begin();

    cleanDatastore(ds, "default");
  }

  @After
  public void tearDown() {
    cleanDatastore(ds, "default");
    helper.tearDown();
    closeable.close();
  }

  @Test
  public void createSaveObject() throws Exception {

    Contact contact = new Contact(TEST_EMAIL);
    ObjectifyService.ofy().save().entity(contact).now();

    Query query = new Query("Contact");
    PreparedQuery pq = ds.prepare(query);
    Entity contactEntity = pq.asSingleEntity(); // Should only be one at this point.
    assertEquals(contactEntity.getProperty("email"), TEST_EMAIL);
  }

  // TODO move to a test utility class once we have more than 1 test
  private static void cleanDatastore(DatastoreService ds, String book) {
    Query query = new Query("Contact").setKeysOnly();
    PreparedQuery pq = ds.prepare(query);
    List<Entity> entities = pq.asList(FetchOptions.Builder.withDefaults());
    ArrayList<Key> keys = new ArrayList<>(entities.size());

    for (Entity e : entities) {
      keys.add(e.getKey());
    }
    ds.delete(keys);
  }
}
