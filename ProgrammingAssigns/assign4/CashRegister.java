public class CashRegister
{
    private float m_cashAmount;
    private int m_transCount;
    private static int objCount = 0;
    CashRegister()
    {
        objCount++;
        m_transCount = 0;
        m_cashAmount = 0.0f;
    }

    public void AddTransaction(float amount)
    {
        m_cashAmount += amount;
        m_transCount ++;
    }

    public int TransactionCount()
    {
        return m_transCount;
    }

    public float Total()
    {
        return m_cashAmount;
    }

    public void ResetTransactions()
    {
        m_transCount = 0;
        m_cashAmount = 0.0f;
    }
    
    public int Count()
    {
        return objCount;
    }


    public static void testCashRegister(CashRegister cr)
    {
        float [] trans = {1000f, 20.25f, -2000f, 23.75f, 67f};

        for(int i = 0; i < trans.length; i++ )
        {
            cr.AddTransaction(trans[i]);
            System.out.println("amount total: " + cr.Total());
            System.out.println("transaction records: " + cr.TransactionCount());
        }
        cr.ResetTransactions();
        System.out.println("RESETTING");
        System.out.println("amount total: " + cr.Total());
        System.out.println("transaction records: " + cr.TransactionCount());
    }

    public static void main(String[] argv)
    {
        System.out.println("*****************registering cr2*********************");
        CashRegister cr1 = new CashRegister();
        testCashRegister(cr1);
        System.out.println("Current cashregister created: " + cr1.Count());
        System.out.println("*****************registering cr2*********************");
        CashRegister cr2 = new CashRegister();
        testCashRegister(cr2);
        System.out.println("Current cashregister created: " + cr2.Count());
    }




}
