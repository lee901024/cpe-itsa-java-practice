#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
    int t, r, c, n;
    char winner;
    cin >> t;
    vector<vector<vector<char>>> grid(
        2, vector<vector<char>>(100, vector<char>(100, ' ')));

    for (int i = 0; i < t; ++i) {
        cin >> r >> c >> n;
        for (int x = 0; x < r; ++x) {
            for (int y = 0; y < c; ++y) {
                cin >> grid[0][x][y];
            }
        }
        for (int day = 0; day < n; ++day) {
            for (int x = 0; x < r; ++x) {
                for (int y = 0; y < c; ++y) {
                    switch (grid[day % 2][x][y]) {
                    case 'R':
                        winner = 'P';
                        break;
                    case 'S':
                        winner = 'R';
                        break;
                    case 'P':
                        winner = 'S';
                        break;
                    default:
                        return -1;
                    }
                    if ((x - 1 >= 0 && grid[day % 2][x - 1][y] == winner) ||
                        (y - 1 >= 0 && grid[day % 2][x][y - 1] == winner) ||
                        (x + 1 < r && grid[day % 2][x + 1][y] == winner) ||
                        (y + 1 < c && grid[day % 2][x][y + 1] == winner)) {
                        grid[(day + 1) % 2][x][y] = winner;
                    } else {
                        grid[(day + 1) % 2][x][y] = grid[day % 2][x][y];
                    }
                }
            }
        }
        for (int x = 0; x < r; ++x) {
            for (int y = 0; y < c; ++y) {
                cout << grid[n % 2][x][y];
            }
            cout << endl;
        }
        cout << endl;
    }
    cout << '\b';
    return 0;
}

/*
12
3 3 1
RRR
RSR
RRR
3 4 2
RSPR
SPRS
PRSP
3 3 1
RRP
RSP
RPR
3 3 1
RPP
RRP
PRR
3 3 3
RPR
RRS
RSR
3 3 3
RSP
SRP
RRP
3 3 10
SRP
PRR
RPS
5 5 1
RPRRS
PSPPP
RSPRR
SSRPP
SRPPP
5 5 1
PRRSP
RSRSR
SSRRP
PSRRR
SRRRR
5 5 2
SRRRS
RPPSR
PRPRS
PRSPP
PRRRR
5 5 2
RPRRS
SRSRP
RRPRP
SRRRR
SSSPP
10 5 1
PPRPP
RPSRR
PSSSP
PPPRP
SRRRR
RSPRR
PPRRS
SPRPP
RRPRS
SRPRR
*/