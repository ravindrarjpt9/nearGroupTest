package com.test.smack;

public class Toto1 {
	public static void main(String[] args) {
		 
        XMPPConnection connection = new XMPPConnection("127.0.0.1", 5222);
      //XMPPConnection connection = new XMPPConnection("localhost",5222);

      //connection.login("admin", "admin");

      ConfigureForm form = new ConfigureForm(FormType.submit);
      form.setPersistentItems(false);
      form.setDeliverPayloads(true);
      form.setAccessModel(AccessModel.open);

      PubSubManager manager = new PubSubManager(connection);
      myNode = manager.createNode("TestNode", form);

      //public SimplePayload(String elementName, String namespace, String xmlPayload)
      SimplePayload payload = new SimplePayload("book","pubsub:test:book", "<book xmlns='pubsub:test:book'><title>Lord of the Rings</title></book>");

      Item<SimplePayload> item = new Item<SimplePayload>(itemId, payload);

      // Required to recieve the events being published

      myNode.addItemEventListener(myEventHandler);

      // Publish item

      myNode.publish(item);

     eventNode = manager.getNode("TestNode");

      eventNode.addItemEventListener(myEventHandler);

      eventNode.subscribe("myJID");

         connection.close();

      }
}
