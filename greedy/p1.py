from queue import PriorityQueue


def DecreasingArray(a, n):
	ss, dif = (0,0)
	pq = PriorityQueue()
	for i in range(n):
		tmp = 0
		if not pq.empty():
			tmp = pq.get()
			pq.put(tmp)
		if not pq.empty() and tmp < a[i]:
			dif = a[i] - tmp
			ss += dif
			pq.get()
			pq.put(a[i])
		pq.put(a[i])
	return ss


n = int(input())
a = [int(x) for x in input().split()]
print(DecreasingArray(a, n))
