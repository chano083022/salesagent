import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        
        JOptionPane.showOptionDialog(null, "Welcome to Sales Agent", 
            "WELCOME!!!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, args, args);
        
        String numberOfAgentsInput = JOptionPane.showInputDialog(null, 
            "Enter How Many Agent's:", "HOW MANY AGENTS", JOptionPane.QUESTION_MESSAGE);
        if (numberOfAgentsInput == null) {  
            JOptionPane.showMessageDialog(null, "Exiting The Operation..", 
                "EXITING", JOptionPane.INFORMATION_MESSAGE);
            return; 
        }
        int numberOfAgents = Integer.parseInt(numberOfAgentsInput);

        agentSales[] agents = new agentSales[numberOfAgents];

        for (int numagent = 0; numagent < numberOfAgents; numagent++) {
            String name = JOptionPane.showInputDialog("Who is agent " + (numagent + 1) + "?");
            if (name == null) { 
                JOptionPane.showMessageDialog(null, 
                    "Exiting The Operation.", "EXITING", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, 
                "Still want to continue entering details for this agent? ",
                 "CONFIRMATION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.NO_OPTION || confirm == JOptionPane.CLOSED_OPTION) {  
                JOptionPane.showMessageDialog(null, 
                    "Exiting The Operation.", "EXITING", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            int salesQty;
            while (true) {
                String salesQtyInput = JOptionPane.showInputDialog(null, 
                    "Please enter the number of sales for " + name + " :", "HOW MANY SALES", JOptionPane.QUESTION_MESSAGE);
                if (salesQtyInput == null) {  
                    JOptionPane.showMessageDialog(null, 
                        "Exiting The Operation.", "EXITING", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                try {
                    salesQty = Integer.parseInt(salesQtyInput);
                    if (salesQty <= 0) {
                        JOptionPane.showMessageDialog(null, 
                            "Please enter a positive number for sales.", "INVALID", JOptionPane.ERROR_MESSAGE);
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, 
                        "Invalid number format. Please enter a valid integer.", "INVALID", JOptionPane.ERROR_MESSAGE);
                }
            }

            int[] sales = new int[salesQty];
            for (int numqty = 0; numqty < salesQty; numqty++) {
                while (true) {
                    String saleInput = JOptionPane.showInputDialog("Enter sale " + (numqty + 1) + " of " + name + ":");
                    if (saleInput == null) {  
                        JOptionPane.showMessageDialog(null,
                             "Exiting The Operation.", "EXITING", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    try {
                        sales[numqty] = Integer.parseInt(saleInput);
                        if (sales[numqty] < 0) {
                            JOptionPane.showMessageDialog(null, 
                                "No negative Number kasi. Try ulit positive ha!", "INVALID", JOptionPane.ERROR_MESSAGE);
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, 
                        "Please enter a valid integer.", "INVALID", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            agents[numagent] = new agentSales(name, sales);
        }

        agentSales topAgentByQty = salesCalculator.findHighestAgentBySalesQty(agents);
        agentSales topAgentByTotal = salesCalculator.findHighestAgentByTotalSales(agents);

        String result = "AGENTS SALES:\n";
        for (int num = 0; num < agents.length; num++) {
            result += agents[num].getName() + " QTY sales: " + agents[num].getSalesQty() +
                      " with total of " + agents[num].getTotalSales() + ".\n";
        }

        result += "\nAgent with the highest sales quantity: " + topAgentByQty.getName() +
                  " with " + topAgentByQty.getSalesQty() + " sales.\n" +
                  "Agent with the highest total sales amount: " + topAgentByTotal.getName() +
                  " with total of " + topAgentByTotal.getTotalSales() + "\n";

        JOptionPane.showMessageDialog(null, result);
    }
}