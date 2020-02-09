/*
 * Complex.java
 * Juan Ayala
 * jumaayal
 * pa6
 * contains methods that can manipulate complex numbers with imaginary numbers
 */
class Complex{

//--------------------------------------------------------------------------
// Private Data Fields 
//--------------------------------------------------------------------------
	private double re;
	private double im;

//--------------------------------------------------------------------------
// Public Constant Fields 
//--------------------------------------------------------------------------
	public static final Complex ONE = Complex.valueOf(1,0);
	public static final Complex ZERO = Complex.valueOf(0,0);
	public static final Complex I = Complex.valueOf(0,1);

//--------------------------------------------------------------------------
// Constructors 
//--------------------------------------------------------------------------
	Complex(double a, double b){
		this.re = a;
		this.im = b;
	}

	Complex(double a){
		this.re = a;
		this.im = 0;
	}
	Complex(String s){
		// Fill in this constructor.
	// It should accept expressions like "-2+3i", "2-3i", "3", "5i", etc..
	// Throw a NumberFormatException if s cannot be parsed as Complex.
	double[] part = new double[2];
	String str = s.trim();
	String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
	String SGN = "[+-]?";
	String OP =  "\\s*[+-]\\s*";
	String I =   "i";
	String OR =  "|";
	String REAL = SGN+NUM;
	String IMAG = SGN+NUM+"?"+I;
	String COMP = REAL+OR+IMAG+OR+REAL+OP+NUM+"?"+I;
	  
	if( !str.matches(COMP) ){
		throw new NumberFormatException("Cannot parse input string \""+str+"\" as Complex");
	} 
	str = str.replaceAll("\\s","");     
	if( str.matches(REAL) ){
		part[0] = Double.parseDouble(str);
		part[1] = 0;
	}else if( str.matches(SGN+I) ){
		part[0] = 0;
		part[1] = Double.parseDouble( str.replace( I, "1.0" ) );
	}else if( str.matches(IMAG) ){
		part[0] = 0;
		part[1] = Double.parseDouble( str.replace( I , "" ) );
	}else if( str.matches(REAL+OP+I) ){
		part[0] = Double.parseDouble( str.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
		part[1] = Double.parseDouble( str.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
	}else{   //  s.matches(REAL+OP+NUM+I) 
		part[0] = Double.parseDouble( str.replaceAll( "("+REAL+").+"  , "$1" ) );
		part[1] = Double.parseDouble( str.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
	}
	this.re = part[0];
	this.im = part[1];
	}

	//---------------------------------------------------------------------------
	// Public methods 
	//---------------------------------------------------------------------------
	
	// Complex arithmetic -------------------------------------------------------
	
	// copy()
	// Return a new Complex equal to this Complex
	Complex copy(){
		double a=this.re;
		double b = this.im;
		return new Complex(a,b);
	}
	
	// add()
	// Return a new Complex representing the sum this plus z.
	Complex add(Complex z){
		double asum = this.re + z.re;
		double bsum = this.im + z.im;
		return new Complex(asum,bsum);
	}
	
	// negate()
	// Return a new Complex representing the negative of this.
	Complex negate(){
		double aneg = (-1)*(this.re);
		double bneg = (-1)*(this.im);
		return new Complex(aneg, bneg);
	}
	
	// sub()
	// Return a new Complex representing the difference this minus z.
	Complex sub(Complex z){
		double adif = this.re -z.re;
		double bdif = this.im -z.im;
		return new Complex(adif,bdif);
	}
	
	// mult()
	// Return a new Complex representing the product this times z.
	Complex mult(Complex z){
		double F = this.re * z.re;
		double OI = (this.re*z.im) + (this.im*z.re);
		double L = (this.im*z.im) *(-1);
		return new Complex((F+L), OI);
	}
	
	// recip()
	// Return a new Complex representing the reciprocal of this.
	// Throw an ArithmeticException with appropriate message if 
	// this.equals(Complex.ZERO).
	Complex recip(){
		if(this.equals(Complex.ZERO)){
			throw new ArithmeticException ("Cannot have a zero as denominator");
		}
		double real = (this.re/(Math.pow(this.re,2) + Math.pow(this.im,2)));
		double imag = ((this.im*-1)/(Math.pow(this.re,2) + Math.pow(this.im,2)));
		return new Complex(real,imag);
	}
	
	// div()
	// Return a new Complex representing the quotient of this by z.
	// Throw an ArithmeticException with appropriate message if 
	// z.equals(Complex.ZERO).
	Complex div(Complex z){
		if(z.equals(Complex.ZERO)){
			throw new ArithmeticException ("Cannot have a zero as denominator");
		}
		Complex reciprocal = z.recip();
		Complex multiply = reciprocal.mult(this);
		return multiply;
	   
	}
	
	// conj()
	// Return a new Complex representing the conjugate of this Complex.
	Complex conj(){
		double bneg = (-1)*(this.im);
		return new Complex(this.re, bneg);
	}
	
	// Re()
	// Return the real part of this.
	double Re(){
		return re;
	}
	
	// Im()
	// Return the imaginary part of this.
	double Im(){
		return im;
	}
	
	// abs()
	// Return the modulus of this Complex, i.e. the distance between 
	// points (0, 0) and (re, im).
	double abs(){
		double square = Math.pow(this.re, 2)+Math.pow(this.im, 2);
		double root = Math.sqrt(square);
		return root;
	}
	
	// arg()
	// Return the argument of this Complex, i.e. the angle this Complex
	// makes with positive real axis.
	double arg(){
		return Math.atan2(im, re);
	}
	
	// Other functions ---------------------------------------------------------
	
	// toString()
	// Return a String representation of this Complex.
	// The String returned will be readable by the constructor Complex(String s)
	public String toString(){
		Double imaginary = this.im;
		Double real = this.re;
		if(imaginary.equals(0.0)){
			return this.re+"";
		}else if(real.equals(0.0)){
			return this.im+"i";
		}else if(this.im<0){
				double positive = (this.im)*(-1);
				return this.re+"-"+positive+"i";
		}
		return this.re+"+"+this.im+"i";
	}
	
	// equals()
	// Return true iff this and obj have the same real and imaginary parts.
	public boolean equals(Object obj){
		Complex object = (Complex) obj;
		Double reObject = object.re,imObject=object.im;
		Double reThis=this.re,imThis=this.im;
		if(reThis.equals(reObject) && imThis.equals(imObject)){
			return true;
		}
		return false;
	}
	
	// valueOf()
	// Return a new Complex with real part a and imaginary part b.
	static Complex valueOf(double a, double b){
		return new Complex(a,b);
	}
	
	// valueOf()
	// Return a new Complex with real part a and imaginary part 0.
	static Complex valueOf(double a){
		return new Complex(a);
	}
	
	// valueOf()
	// Return a new Complex constructed from s.
	static Complex valueOf(String s){
		return new Complex(s);
	}

}