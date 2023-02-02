# markov-decision-process-value-iteration-program
Based on this: https://levelup.gitconnected.com/fundamentals-of-reinforcement-learning-value-iteration-and-policy-iteration-with-tutorials-a7ad0049c84f

```mdpvi.java``` 
  - Hardcoded answer for problem above.

```mdpviusi.java``` 
  - Allows for user input based on problem above.
  - No 'end' to chain. 
  - User must define:
    -  no. of states, actions & iterations. 
    -  each path's probability and rewards. 
  - Increase iterations untill values reach stability.
  - values output are:
    -  state 0's value
    -  state 1's value
    -  .....
    -  state N's value

Both assume ```γ = 0.9 ```, aka: gamma = 0.9 in calculations.
