package pcd.lab10.rabbitmq;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class Test3_PublisherWithRoutingDirect {

  private static final String EXCHANGE_NAME = "direct_logs";

  public static void main(String[] argv) throws Exception {

    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "direct");

    String routingKey = "tag-1"; // getSeverity(argv);
    String message = "hello2"; // getMessage(argv);

    channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

    channel.close();
    connection.close();
  }

  private static String getSeverity(String[] strings){
    if (strings.length < 1)
    	    return "tag-1";
    return strings[0];
  }

  private static String getMessage(String[] strings){
    if (strings.length < 2)
    	    return "Hello World!";
    return joinStrings(strings, " ", 1);
  }

  private static String joinStrings(String[] strings, String delimiter, int startIndex) {
    int length = strings.length;
    if (length == 0 ) return "";
    if (length < startIndex ) return "";
    StringBuilder words = new StringBuilder(strings[startIndex]);
    for (int i = startIndex + 1; i < length; i++) {
        words.append(delimiter).append(strings[i]);
    }
    return words.toString();
  }
}

