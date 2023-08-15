<img src="https://github.com/ubangura/Tic-Tac-Toe-AI/blob/main/src/main/app/assets/icons/logo.png" align="right" />

# Tic Tac Toe AI 🤖
> The minimax algorithm makes the most optimal move in any turn-based zero-sum game like tic tac toe

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

In the terminal run
```bash
git clone https://github.com/ubangura/Tic-Tac-Toe-AI.git
```
to copy the code from the repository to your local computer.

---

<!-- Minimax Algorithm -->
<h2 id="minimax-algorithm"> 🎮 Minimax Algorithm</h2>

<!-- Alpha-beta Pruning -->
<h3 id="alpha-beta-pruning"> &nbsp; &nbsp; ❌ Alpha-beta Pruning</h3>

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
