#!/usr/bin/perl
use strict;
use warnings;

sub match
{
    my $str = shift;

    unless($str =~ /^hi\sd/si){
        return 1 if($str =~ /^hi\s/si);
    }
    return 0;
}

# Tail starts here
my $testcases = <>;
for (1..$testcases){
    my $str = <>;
    print "$str" if(match($str));
}
print "\n";