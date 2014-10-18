#!/usr/bin/perl
use strict;
use warnings;

my (%us,%uk);

sub match
{
    my $str = shift;

    map {$us{$_} = '';} ($str =~ /\s([a-z|A-Z]+)+ze\s/);
    map {$uk{$_} = '';} ($str =~ /\s([a-z|A-Z]+)+se\s/);
    return 1;
}


# Tail starts here
my $testcases = <>;
for (1..$testcases){
    my $str = <>;
    chomp($str);
    match($str);

    my $count = 0;
    foreach my $key(keys %us){
        $count += 2 if(exists $uk{$key});
    }
    print $count;
}