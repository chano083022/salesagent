public class salesCalculator {
    public static agentSales findHighestAgentBySalesQty(agentSales[] agents) {
        if (agents.length == 0) return null;

        agentSales highestAgent = agents[0];
        for (int num = 1; num < agents.length; num++) {
            if (agents[num].getSalesQty() > highestAgent.getSalesQty()) {
                highestAgent = agents[num];
            }
        }
        return highestAgent;
    }

    public static agentSales findHighestAgentByTotalSales(agentSales[] agents) {
        if (agents.length == 0) return null; 

        agentSales highAgent = agents[0];
        for (int num = 1; num < agents.length; num++) {
            if (agents[num].getTotalSales() > highAgent.getTotalSales()) {
                highAgent = agents[num];
            }
        }
        return highAgent;
    }
}
