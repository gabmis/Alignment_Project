How to use our program:
Place the .txt file containing your DNA sequences in the src directory and name it "seq".

You then run the Main_Interactive.java file.

The Tasks asked in the PDF will be accomplished step by step and the results will be printed in the console.

You will be asked to enter the parameters (gap1 and gap2, k, th and thl).

For Task7 you will be asked which method you want to run.
We offer the possibility to run three methods:

	*First method: Naive Method.
		It simply tries all possible words and store the ones wich match the criteria with th.
	 	This method is very naive and slow but it uses very few memory. We recommand that tou don't use it
		for k>???

	*Second method: we use a tree to store and compute the seeds. This method is faster that the first one.
			Thanks to an optimisation we manage to make the computation about 20 times faster than the first method.
			However this method requires a lot of memory. Our computers don't have enough memory for k>5.

	*Third method: We only compute the values of words we encounter in the string t. For reasonnable length of t it is the fastest
			method and it doesn't use more memory than the length of t.


			
