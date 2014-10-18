#!/usr/bin/perl
use strict;
use warnings;

sub match
{
    my $str = shift;

    return 'VALID' if($str =~ /^[a-z]{0,3}\d{2,8}[A-Z]{3,}$/s);
    return 'INVALID';

}

# Tail starts here
my $testcases = <>;
for (1..$testcases){
    my $str = <>;
    print match($str)."\n";
}