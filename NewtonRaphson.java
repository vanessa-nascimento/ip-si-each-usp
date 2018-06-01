/*********************************************************************/
/**   <Vanessa Alves do Nascimento>                                 **/
/**                                                                 **/
/**   <20/05/2018>                                                  **/
/*********************************************************************/
class NewtonRaphson {
	
	/* METODO DE NEWTON RAPHSON
	 * Imagine que voce faz uma determinada aplicacao inicial D0 em um fundo de investimento, em uma determinada data t0.
	 * A partir dessa data, e em dias esporadicos, voce faz novos depositos Di nesse mesmo fundo.
	 * Passado um certo tempo, voce verifica o saldo do fundo, e entao se pergunta qual teriam sido
	 * os juros (compostos) medios mensais praticados no perıodo?
	 */
	
	/* Depósitos realizados, com saldo final */
	static double[] depositos;
	
	/* Datas correspondentes aos depósitos feitos e saldo final */
	static int[] datas;
	
	
	
	static double calculo(double juros, double epsilon) {
		
		double saldo = depositos[depositos.length-1], finalData = datas[datas.length-1], fj = 0, fjdx = 0, jfinal = 0;
		
		//jk+1
		for(int i = 0; i < depositos.length-1; i++) {
			
			//funcao f(j)
			double fn = (depositos[i]*Math.pow((1 + juros),(finalData-datas[i])));
			
			//soma das func funcoes(j)
			fj += fn;
			
			//funcão dx(f(j))
			double fndx = (finalData-datas[i])*depositos[i]*Math.pow((1 + juros),((finalData-datas[i])-1));
			
			//soma das funcoes dx(f(j))
			fjdx += fndx;
			
			
			//conta final
			jfinal = (juros-((fj-saldo)/fjdx));
		
		}
		return jfinal;
	}
	
	
	static double newton(double epsilon){
		if(epsilon > 0 && epsilon < 1){

			double j = 0.5, jn= 0;
			
			//|jk+1 - jk| >= epsilon
			while(Math.pow(jn-j,2) >= Math.pow(epsilon,2)) {
				
				j = jn;
				jn = calculo(j, epsilon);
				
			}		
			return jn;
		}
		else return -1;
	}
}
