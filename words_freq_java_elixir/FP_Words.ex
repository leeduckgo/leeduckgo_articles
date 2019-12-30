defmodule FPWords do
 @moduledoc """
    Documentation for Get Words Freq
  """

  @non_words ["an", "a", "on"]
  def fetch_words_req(words) do
    words
    |> String.split()
    |> reject_non_words()
    |> count()
  end

  def reject_non_words(words_list) do
    Enum.reject(words_list, fn word -> reject_non_word(word) end)
  end

  def reject_non_word(word) do
    word
    |> String.downcase()
    |> Kernel.in(@non_words)
  end

  defp count(words) when is_list(words) do
    Enum.reduce(words, %{}, &update_count/2)
  end

  defp update_count(word, acc) do
    Map.update(acc, String.to_atom(word), 1, &(&1 + 1))
  end
end
