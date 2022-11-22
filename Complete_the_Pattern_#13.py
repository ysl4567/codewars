get_r = lambda y: str((y + 1) % 10)
row = lambda n, i: ' ' * i + get_r(i) + ' ' * max(0, 2 * n - 3 - i * 2) + (get_r(i) if i != n - 1 else '') + ' ' * i
multiply = lambda s, t: s if not isinstance(t, int) or t <= 1 else s + multiply(s, t - 1)[1:]
def pattern(n, x = 1, *ign):
  if n < 1: return ''
  top = [multiply(row(n, i), x) for i in range(n - 1)]
  return '\n'.join(top + [multiply(row(n, n - 1), x)] + list(reversed(top)))
