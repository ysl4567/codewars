public static class Kata
{
  public static bool Disjunction(bool[] operands, bool isExclusive = false)
  {
    if (operands == null)
    {
      throw new System.ArgumentNullException("operands");
    }
    
    if (isExclusive)
    {
      var result = false;
      
      foreach (var operand in operands)
      {
        result ^= operand;
      }
      
      return result;
    }
    
    foreach (var operand in operands)
    {
      if (operand)
      {
        return true;
      }
    }
    
    return false;
  }
}
