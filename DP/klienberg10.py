def max2machines(A, B):
    A = [0, *A]
    B = [0, *B]
    assert len(A) == len(B)
    n = len(A)
    res = [
        [0, A[1]], 
        [0, B[1]],
    ]
    for i in range(2, n):
        res[0].append(A[i] + max(res[0][i-1], res[1][i-2]))
        res[1].append(B[i] + max(res[1][i-1], res[0][i-2]))
    
    return res

print(max2machines(
    A=[10, 1, 1, 10],
    B=[5, 1, 20, 20],
))

