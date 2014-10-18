#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

sub missing
{
	my %argHash = @_;

	my @array1 = @{$argHash{'array1'}};
	my @array2 = @{$argHash{'array2'}};

	my %numHash = ();
	my @retArray = ();
	my $count = 0;

	foreach (0..$#array1)
	{
		if($array1[$_] != $array2[$_+$count])
		{
			push @retArray,$array2[$_+$count] if(!exists $numHash{$array2[$_+$count]});
			$numHash{$array2[$_+$count]} = 1;
			$count++;
		}
	}

	foreach ($#array1..$#array2-$count)
	{
		push @retArray,$array2[$_] if(!exists $numHash{$array2[$_]});
		$numHash{$array2[$_]} = 1;
	}

	return "@retArray";
}

my $size1 = <>;
my @array1 = split(' ',<>);
my $size2 = <>;
my @array2 = split(' ',<>);
print missing('array1' => \@array1, 'array2' => \@array2);
print "\n";