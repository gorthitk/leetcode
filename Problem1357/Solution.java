/**
 * @author tgorthi
 * @since Jun 2020
 */
class Cashier
{
    private final int[] pricesByProductId;
    private final int n;
    private final double discount;
    private int counter = 0;

    public Cashier(int n, int discount, int[] products, int[] prices)
    {
        this.n = n;
        this.discount = 1 - ((double) discount / 100);
        pricesByProductId = new int[201];
        for (int i = 0; i < products.length; i++)
        {
            pricesByProductId[products[i]] = prices[i];
        }
    }

    public double getBill(int[] product, int[] amount)
    {
        double billAmount = 0;
        for (int i = 0; i < product.length; i++)
        {
            billAmount += pricesByProductId[product[i]] * amount[i];
        }
        if (++counter % n == 0)
        {
            billAmount = billAmount * discount;
        }
        return billAmount;
    }
}