<img src="https://github.com/ubangura/Tic-Tac-Toe-AI/blob/main/src/main/app/assets/icons/logo.png" align="right" />

# Tic Tac Toe AI 🤖
> A dynamic AI with a 0% loss rate against humans

<p align="center"> 
  <img src="demo.gif" alt="AI (Player O) wins against human (Player x)">
</p>

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary> 📖 Table of Contents</summary>
  <ul>
    <li><a href="#motivation"> Motivation</a></li>
    <li><a href="#overview"> Overview</a></li>
    <li><a href="#getting-started-guide"> Getting Started Guide</a>
    </li>
    <li><a href="#minimax-algorithm"> Minimax Algorithm</a>
      <ul>
        <li><a href="#alpha-beta-pruning"> Alpha-beta Pruning</a></li>
      </ul>
    </li>
    <li><a href="#references"> References</a></li>
  </ul>
</details>

---

<!-- Motivation -->
<h2 id="motivation"> 💡 Motivation</h2>
<img src="https://stockfishchess.org/images/logo/icon_512x512@2x.png" width="15%" align="right" />
As an avid chess player (with an ELO of 1042), I developed this project to explore game theory and be a starting point for understanding the algorithms behind chess engines. After three years of playing chess, I wondered how the underlying algorithms of bots are adjusted to create varying difficulty levels. Chess engines are complex and use techniques such as neural networks. But a much simpler element of these engines is the minimax algorithm. Through learning more about minimax, new questions came up related to how developers factor it into difficulty settings. Do the engineers decrease the depth of the game tree, limit the branches searched for each possible position, choose the nth best-ranked move, or any combination of these? To explore these questions, I applied the minimax algorithm to tic tac toe.

---

<!-- OVERVIEW -->
<h2 id="overview"> ☁️ Overview</h2>
In this project, the AI uses the minimax algorithm with alpha-beta pruning to make the best next move. I implemented the AI to have an adjustable search depth to speed up the decision-making time on larger board sizes and allow for comparing the strengths of AI with varying depths.
<br>
<br>

**File Structure**

    │
    ├── console implementation
    │   ├── test
    │   │   ├── AITests.java
    │   │   ├── BoardTests.java
    │   │   ├── HumanTests.java
    │   │   ├── TicTacToeTests.java
    │   │
    │   ├── tictactoe
    │   │   ├── AI.java
    │   │   ├── Board.java
    │   │   ├── Driver.java
    │   │   ├── GameStatus.java
    │   │   ├── Human.java
    │   │   ├── Mark.java
    │   │   ├── Player.java
    │   │   ├── TicTacToe.java

---

<!-- Getting Started Guide -->
<h2 id="getting-started-guide"> 🛠️ Getting Started Guide</h2>

*Note: you will need the Java Development Kit (JDK) installed on your local computer. If you need to install one, you can do so at [Oracle Java SE](https://www.oracle.com/java/technologies/javase-downloads.html).*
<br>

Run the command below in the terminal to copy the code from the repository to your local computer.
```bash
git clone https://github.com/ubangura/Tic-Tac-Toe-AI.git
```

---

<!-- Minimax Algorithm -->
<h2 id="minimax-algorithm"> 🎮 Minimax Algorithm</h2>

> The minimax algorithm makes the most optimal move in any turn-based zero-sum game

In programming a game AI, we ideally want to look ahead and evaluate all possible next moves. However, this is not always realistic due to space and time constraints. For example, in chess, there are between 10<sup>40</sup> and 10<sup>120</sup> final game states the computer would need to evaluate. So, we look ahead as far as possible. We can visualize possible next moves as a game tree where the root node is the current game state, and all its successors represent possible moves.

<br>

<img src="https://github.com/ubangura/Tic-Tac-Toe-AI/blob/main/readme%20assets/empty_tree.png" width="30%" align="right"/>

Game Tree Features:
- Branching factor (b) &rarr; for each node we can derive n nodes
- Depth (d) &rarr; the longest path from the root to a leaf node
- Leaf node &rarr; final game state for a branch
- b<sup>d</sup> &rarr; maximum number of static evaluations

In this game tree, the branching factor and depth of the tree are both 2, so the AI would perform 4 final game state evaluations.

<br>

<img src="https://github.com/ubangura/Tic-Tac-Toe-AI/blob/main/readme%20assets/completed_minimax_tree.png" width="50%" align="right"/>

In the minimax algorithm, there are two players, the minimizing player, and the maximizing player. The minimizer wants to minimize the static evaluation (score) propagated to the root node. The maximizer wants to maximize the static evaluation.

Here, the root node represents the turn of the maximizer. The next level of the tree is the minimizer's turn which leads to four leaf nodes evaluated as 2, 7, 1, and 8. With the evaluations determined, we work our way back up the tree. The minimizer will choose the min of 2 and 7 in the left subtree and the min of 1 and 8 in the right subtree. Then the maximizer will choose the max of 2 and 1. With the tree finished, the maximizer now knows to follow the branch that leads to a static evaluation of 2.

*Note: The minimax algorithm assumes the minimizer will play perfectly. In other words, the minimizer will always choose the move leading to the worst outcome for the maximizer.*

<!-- Alpha-beta Pruning -->
<h3 id="alpha-beta-pruning"> ❌ Alpha-beta Pruning</h3>

> Alpha-beta pruning is an extension to the minimax algorithm that skips the evaluation of branches in the game tree which won't affect the outcome

---

<!-- REFERENCES -->
<h2 id="references"> 📚 References</h2>

<ul>
  <li>
    <p>MIT OpenCourseWare: <a href="https://www.youtube.com/watch?v=STjW3eH0Cik">6. Search: Games, Minimax, and Alpha-Beta</a></p>
  </li>
  <li>
    <p>YouTube video from Sebastian Lague: <a href="https://www.youtube.com/watch?v=l-hh51ncgDI">Algorithms Explained – minimax and alpha-beta pruning</a></p>
  </li>
  <li>
    <p>YouTube video from Robert Miles: <a href="https://www.youtube.com/watch?v=8AvIErXFoH8">What's the Use of Utility Functions?</a></p>
  </li>
  <li>
    <p>(A little joke) YouTube video from Chess.com: <a href="https://www.youtube.com/watch?v=lP36_hLMHIc">Stockfish Chess Engine Explains Most Famous Chess Game</a></p>
  </li>
</ul>
