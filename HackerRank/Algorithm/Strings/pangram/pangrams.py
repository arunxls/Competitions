#!/usr/bin/python

import fileinput
import re

alph = set()
def main():
    for line in fileinput.input():
        for s in line:
            if not s.lower() in alph and re.match(r'\w', s.lower()):
                alph.add(s.lower())

            if len(alph) == 26:
                print "pangram"
                return
    print "not pangram"
    return

if __name__ == '__main__':
    main()
