# TinyCompiler
This is a simple compiler leading end.

### uml
	This direction includes the uml classDiagram about this project.You 
can open the tinyCompilerUmlDiagram.uml by ArgoUML (my version is v0.34)
	But I haven't finish it because I only begin to learning UML in this semester.

### test
	There is the test result for src/input2.txt:
```
	L1:L4:	i = i + 1
	L6:	t1 = i * 8
	t2 = a [ t1 ]
	if t2 < v goto L4
	L5:	j = j - 1
	L8:	t3 = j * 8
	t4 = a [ t3 ]
	if t4 < v goto L5
	L7:	iffalse i >= j goto L9
	L10:	goto L3
	L9:	t5 = i * 8
	x = a [ t5 ]
	L11:	t6 = i * 8
	t7 = j * 8
	t8 = a [ t7 ]
	a [ t6 ] =t8
	L12:	t9 = j * 8
	a [ t9 ] =x
	L13:	goto L1
	L3:L2:
```
### Reference
	Book: Alfred V. and Monica S. and Ravi Sethi and Jeffrey D. 
	"Compilers Principes,Techniques,&amp; Tools" (Chinese Edition).
	pp.43-66 and appendix A.

