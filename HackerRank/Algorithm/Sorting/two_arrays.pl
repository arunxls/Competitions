#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

sub min_value
{
	my %argHash = @_;

	my @array1 = sort { $a <=> $b }  @{$argHash{'array1'}};
	my @array2 = reverse sort { $a <=> $b } @{$argHash{'array2'}};
	my $num    = $argHash{'num'};

	for (0..$#array1)
	{
		return 'NO' if ($array1[$_]+$array2[$_] < $num);
	}
	return 'YES';
}

my $test_cases = <>;
for (my $index = 0; $index < $test_cases; $index++)
{
	my ($arraySize,$num) = split(' ',<>);
    my @array1 = split(' ',<>);
    my @array2 = split(' ',<>);
    print min_value('array1' => \@array1, 'array2' => \@array2, 'num' => $num);
    print "\n";  
}

# print min_value
# (
# 	'array1' => [split(' ','54 65 7 38 39 90 80 93 38 75 11 42 1 53 64 28 92 91 46 7 91 35 61 1 40 67 86 55 15 68 64 83 13 4 82 60 63 52 74 68 54 81 36 18 53 23 48 34 58 2 36 64 50 34 10 7 78 93 59 44 45 1 87 47 36 66 1 24 60 12 46 81 30')],
#  	'array2' => [split(' ','1 41 25 9 84 34 53 10 25 48 7 52 20 52 1 50 9 29 38 21 1 88 40 81 1 48 11 31 68 2 35 52 53 46 49 83 1 8 39 75 34 23 67 1 43 87 54 82 58 82 29 20 26 12 10 57 84 91 79 49 69 30 32 43 24 91 22 73 67 27 87 47 30')],
#  	'num' => 95,
# );