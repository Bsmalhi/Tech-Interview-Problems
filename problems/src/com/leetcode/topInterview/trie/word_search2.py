class TrieNode:
  def __init__(self):
    self.children = {}
    self.isWord = False
    self.refs = 0
    
  def addword(self, word):
    curr = self
    curr.refs += 1
    for c in word:
      if c not in curr.children:
        curr.children[c] = TrieNode()
        curr.refs += 1
      curr = curr.children[c]
    curr.isWord = True;

  def removeWord(self, word):
    curr = self
    for c in word:
      curr = curr.children[c]
      curr.refs -=1

class word_search:
  def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
    res, visit = set(), set()
    root = TrieNode()
    for w in words:
      root.addWords(w)
    rows = len(board)
    cols = len(board[0])
    def dfs(r, c, word, node):
      if (r not in range(rows) or c not in range(cols) or board[r][c] not in node.children or (r,c) not in visit or node.children[board[r][c]].refs < 1):
        return
      visit.add((r,c))
      node = node.children[board[r][c]]
      word += board[r][c]
      if node.isWord:
        res.add(word)
        node.isWord = False
        node.removeWord(word)
      dfs(r + 1, c, word, node)
      dfs(r - 1, c, word, node)
      dfs(r, c + 1, word, node)
      dfs(r, c - 1, word, node)
      visit.remove((r,c))
      
  for r in range(rows):
    for c in range(cols):
      dfs(r, c, "", root):
  return list(res)
    
