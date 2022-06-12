from itertools import permutations
from unittest import result

# initial
guys = [0, 1, 2, 3] # A, B, C, D
gals = [4, 5, 6, 7] # a, b, c ,d
mansPrefer = [[6, 5, 7, 4], [5, 4, 6, 7], [5, 7, 4, 6], [6, 4, 7, 5]]
wemansPrefer = [[0, 1, 3, 2], [2, 0, 3, 1], [2, 1, 3, 0], [1, 0, 2, 3]]
n = len(guys)

valid_pairings = [sorted(zip(i, gals)) for i in permutations(guys)]

results = []
for k, pairs in enumerate(valid_pairings):
    flags = []
    for i, mar1 in enumerate(pairs[:-1]):
        for mar2 in pairs[i+1:]:
            tmp = [
                mansPrefer[mar1[0]].index(mar1[1]) < mansPrefer[mar1[0]].index(mar2[1]), # greater index, less proiroty
                mansPrefer[mar2[0]].index(mar2[1]) < mansPrefer[mar2[0]].index(mar1[1]),
                wemansPrefer[mar1[1]%n].index(mar1[0]) < wemansPrefer[mar1[1]%n].index(mar2[0]),
                wemansPrefer[mar2[1]%n].index(mar2[0]) < wemansPrefer[mar2[1]%n].index(mar1[0]),
            ]
            flags.append(True if any(tmp) else False)

    print(f'{k+1}\'th match is', '' if all(flags) else 'not', f'stable:\n\t{pairs}\n')


# This code is contributed by Soroush Fathi