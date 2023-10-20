result =  rand7()+(rand7()-1)*7 --> will generate number between 0 to 49
but we need number between 1 to 10 so formula will be --> result%10+1.
**but here there is a problem that some number doesn't have equal probability to generate number**
example: 1%10=1, 2%10=2, ....9%10=9
41%10=1, 42%10 = 2,........ 49%10=9
so need to regenerate number if number is greater than 40.
to make number uniform.
Note: 49%10 = 9 so 49-9=40, if ramber is greater than 40 regenerate.