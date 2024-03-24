# UCB CS61A: Structure and Interpretation of Computer Programs
## Lab01
布尔运算符的优先级：
- not is highest priority
- and 
- or
- Python values such as **0, None, '' (the empty string), and [] (the empty list)** are considered **false** values
All other values are considered true values.

python环境中的快捷键：
- Ctrl+L ：清屏

错误类型：
- **SyntaxError**	Contained improper syntax (e.g. missing a colon after an if statement or forgetting to close parentheses/quotes)  
- **IndentationError**	Contained improper indentation (e.g. inconsistent indentation of a function body)  
- **TypeError**	Attempted operation on incompatible types (e.g. trying to add a function and a number) or called function with the wrong number of arguments  
- **ZeroDivisionError**	Attempted division by zero

## Project 1: Hog
规则：
- **Pig Out**：
  如果有一个骰子输出为1，则得分为1

- **Free Bacon**：
  选择掷零骰子的玩家得到的点数等于10减去对手得分的个位数，再加上对手得分的十位

- **Feral Hogs**：
  如果你掷出的骰子数与你在前一回合得到的点数相差2分(绝对差值)，那么你在这一回合可以多得3分。将第一个转弯前的一个转弯视为0分。在计算前一回合得分时，不考虑任何先前的野猪奖励或猪交换(下一条规则)。

- **Swine Swap**：
  在当前玩家的得分加上该回合的得分后，如果当前玩家得分的个位数与对手得分的个位数之差的绝对值等于对手得分的十位值，则应该交换分数。交换可能发生在一个回合结束时，其中一名玩家达到目标分数，导致对手获胜。

