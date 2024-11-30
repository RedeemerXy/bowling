## Bowling Game

Assumptions: only valid values, rules are adhered to.

- single rolls and sum of frame rolls are always in range [0;10]
- in case of a strike, we enter 0 as second roll
- we model the bonus roll as an additional frame (x,0)

Ideas:

- linked list of frames, back to first approach commented out in Frame class
- model bonus roll differently
- make it possible to calculate intermediate results like they would be shown in a real bowling alley
- add validations for correct usage