#!/usr/bin/perl
use strict;
use warnings;

sub draws
{
	my $pairs = shift;
	return 2 if ($pairs == 1);
	return ($pairs + 1);
}

#Tail starts here
my $test_cases = <>;
for (my $index = 0; $index < $test_cases; $index++)
{
    my $input = <>;
    chomp $input;
    print draws($input);
    print "\n";  
}

# print keyword('SPORT','LDXTW KXDTL NBSFX BFOII LNBHG ODDWN BWK');