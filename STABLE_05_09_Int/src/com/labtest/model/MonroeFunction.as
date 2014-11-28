package com.labtest.model
{
	public class MonroeFunction
	{
		public var slope:int;
		public var constant:int;
		
		public function MonroeFunction()
		{
		}
		
		public function getValue(x:int): int{
			
			return (slope*x+constant);
		}
		
	}
}