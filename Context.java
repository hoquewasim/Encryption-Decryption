package Strategy;

public class Context {
    private StrategyEnc strategyEnc;
    private StrategyDec strategyDec;
    private ShiftStrategy shiftStrategy;
    public Context(StrategyEnc strategyEnc)
    {
        this.strategyEnc = strategyEnc;
    }
    public Context(StrategyDec strategyDec)
    {
        this.strategyDec = strategyDec;
    }
    public Context(ShiftStrategy shiftStrategy)
    {
        this.shiftStrategy = shiftStrategy;
    }

    public String findEnc(int key, String data)
    {
        return this.strategyEnc.enc(key, data);
    }
    public String findDec(int key, String data)
    {
        return this.strategyDec.dec(key, data);
    }

    public String findShift(int key, String data)
    {
        return this.shiftStrategy.shiftAlg(key, data);
    }
    public String findShiftInverse(int key, String data)
    {
        return this.shiftStrategy.shiftAlg(key, data);
    }

}
