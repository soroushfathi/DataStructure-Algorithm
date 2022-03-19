class ISort:
    def sort(self, A):
        pass

class BucketSort(ISort):
    def sort(self, A):
        n = len(A)
        B = [[] for _ in range(n)]
        for i in range(n):
            h = n * A[i]
            B[h].append(A[i])
        for h in range(n):
            B[h].sort()
        C = []
        for h in range(n):
            C.extend(B[h])
        return C
