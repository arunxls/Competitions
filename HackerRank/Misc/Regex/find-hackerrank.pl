#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

sub hacker
{
    my $str = shift;
    my $return = -1;

    if($str =~ /^hackerrank.*hackerrank$/s) {
        $return = 0;
    } elsif($str =~ /^hackerrank$/s) {
        $return = 0;
    } elsif($str =~ /^hackerrank/s) {
        $return = 1;
    } elsif($str =~ /hackerrank$/s) {
        $return = 2;
    }

    return $return;
}

# Tail starts here
my $testcases = <>;
for (1..$testcases){
    my $str = <>;
    print hacker($str)."\n";
}