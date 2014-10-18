#!/usr/bin/perl

# https://www.hackerrank.com/challenges/gem-stones

use strict;
use warnings;

use Data::Dumper;

sub matches {
    my ($stones) = @_;

    my $element_hash = {};

    foreach my $stone (@{$stones}) {
        my $sub_element_hash = {};
        $sub_element_hash->{$_} = 1 for(split('',$stone));
        $element_hash->{$_}++ for(keys %{$sub_element_hash});
    }

    my $count = 0;
    foreach my $element (keys %{$element_hash}) {
        $count++ if($element_hash->{$element} == scalar @{$stones})
    }
    return $count;
}

# Tail starts here
my $testcases = <>;
my $stones = [];
for (1..$testcases){
    my $str = <>;
    chomp($str);
    push(@{$stones},$str);
}

print matches($stones);
