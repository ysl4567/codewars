class Node
  constructor: (data) ->
    @data = data
    @next = null
  tail: (t=this) ->
    (while t=t.next then t).pop() or this
    
append = (listA, listB) ->
  return listA or listB unless listA and listB
  listA.tail().next = listB
  listA
