public class agentSales {
    private String name;
    private int[] sales;

    public agentSales(String name, int[] sales) {
        this.name = name;
        this.sales = sales;
    }

    
    public int getTotalSales() {
        int sum = 0;
        for (int num = 0; num < sales.length; num++) {
            sum += sales[num];
        }
        return sum;
    }

    public int getSalesQty() {
        return sales.length;
    }

    // Getter for name
    public String getName() {
        return name;
    }
}
