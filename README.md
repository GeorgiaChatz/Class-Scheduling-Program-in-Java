# Class Scheduling Program in Java

It is an implementation of a project in Artificial Intelligence course.
We develop software in **Java**  which build a high school curriculum using state-space search algorithms.
This problem belongs to **Constraint Satisfaction Problems**.

# Project Informations

We use an algorithm called backtracking search to solve this CSP problem. It's nothing but DFS (with the slightly different
implementation we discussed above) where when we find ourselves in a situation that violates some limitation, we go back and
try another value.

**_Pseudocode of BackTracking_**

1. procedure BacktrackingSearch(csp)
 2. return RecursiveBacktracking({}, csp)
3. end procedure
4. procedure RecursiveBacktracking(assignment, csp)
5. if assignment is complete then
6. return assignment
7. end if
8. var = SelectUnassignedVariable(assignment, csp)
9. for each value in OrderDomainValues(var, assignment, csp) do
10. if value consistent with assignment and Constraints[csp] then
11. add {var = value} in assignment
12. result = RecursiveBacktracking(assignment, csp)
13. if result ̸ = Failure then
14. return result
15. end if
16. remove {var = value} from assignment
17. end if
18. end for
19. return Failure
20. end procedure

