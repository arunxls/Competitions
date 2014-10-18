#!/usr/bin/perl
use strict;
use warnings;

# Tail starts here
my $testcases = <>;
my $count = 0;

for (1..$testcases){
    my $str = <>;
    $count += $str =~ /hackerrank/si;
}

print "$count\n";