# Python3 implementation of the approach
# Function to return the minimum cost
# to connect the given ropes
def MinCost(arr, n):
    # dp[i][j] = minimum cost in range (i, j)
    # sum[i][j] = sum of range (i, j)
    dp = [[0 for i in range(n + 5)] for i in range(n + 5)]
    sum = [[0 for i in range(n + 5)] for i in range(n + 5)]

    for i in range(n):
        k = arr[i]
        for j in range(i, n):
            if (i == j):
                sum[i][j] = k
            else:
                k += arr[j]
                sum[i][j] = k

    # Computing minimum cost for all
    # the possible interval (i, j)
    # Left range
    for i in range(n - 1, -1, -1):
        # Right range
        for j in range(i, n):
            dp[i][j] = 10**9
            # No cost for a single rope
            if (i == j):
                dp[i][j] = 0
            else :
                for k in range(i, j):
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[i][j])
    return dp[0][n - 1]

# Driver code
arr = [7, 6, 8, 6, 1, 1]
n = len(arr)

print(MinCost(arr, n))

# This code is contributed
# by Mohit Kumar