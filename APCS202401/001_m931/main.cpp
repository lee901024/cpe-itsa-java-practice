/*
https://zerojudge.tw/ShowProblem?problemid=m931
*/
#include <iostream>

using namespace std;

struct Player {
    int attack;
    int defence;
    int score;
};

int main() {
    int c;
    Player Players[2] = {{0, 0, 0}, {0, 0, 0}};
    bool firstIsMax = true;
    cin >> c;
    while (c--) {
        int attack, defence;
        cin >> attack >> defence;
        int score = attack * attack + defence * defence;
        if (score > Players[firstIsMax].score) { // greater than second large?
            Players[firstIsMax].score = score;
            Players[firstIsMax].attack = attack;
            Players[firstIsMax].defence = defence;
            if (score > Players[!firstIsMax].score) { // greater than first large?
                firstIsMax = !firstIsMax;
            }
        }
    }
    cout << Players[firstIsMax].attack << " " << Players[firstIsMax].defence << endl;
    return 0;
}
/*
3
3 1
5 2
1 4
*/
/*
6
6 6
1 3
8 6
5 4
2 8
7 2
*/
/*
5
34 35
84 32
39 79
59 89
59 31
*/