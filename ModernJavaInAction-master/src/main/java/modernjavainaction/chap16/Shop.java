package modernjavainaction.chap16;

import static modernjavainaction.chap16.Util.delay;
import static modernjavainaction.chap16.Util.format;

import java.util.Random;

public class Shop {

  private final String name;
  private final Random random;

  public Shop(String name) {
    this.name = name;
    random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
  }

  public String getPrice(String product, Shop shop) {

    System.out.println("Getting price for " + product + " at " + shop);

    double price = calculatePrice(product);
    Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];

    String priceStr = name + ":" + price + ":" + code;

    System.out.println("Price is " + priceStr);

    return priceStr;
  }

  public double calculatePrice(String product) {
    delay();
    return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Shop{" +
            "name='" + name +
            '}';
  }
}
