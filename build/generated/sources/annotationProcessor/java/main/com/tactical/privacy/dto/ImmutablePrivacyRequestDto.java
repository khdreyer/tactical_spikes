package com.tactical.privacy.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PrivacyRequestDto}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePrivacyRequestDto.builder()}.
 */
@Generated(from = "PrivacyRequestDto", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutablePrivacyRequestDto implements PrivacyRequestDto {
  private final String phone;
  private final String email;
  private final long companyId;

  private ImmutablePrivacyRequestDto(String phone, String email, long companyId) {
    this.phone = phone;
    this.email = email;
    this.companyId = companyId;
  }

  /**
   * @return The value of the {@code phone} attribute
   */
  @JsonProperty("phone")
  @Override
  public String phone() {
    return phone;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @JsonProperty("email")
  @Override
  public String email() {
    return email;
  }

  /**
   * @return The value of the {@code companyId} attribute
   */
  @JsonProperty("companyId")
  @Override
  public long companyId() {
    return companyId;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PrivacyRequestDto#phone() phone} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for phone
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePrivacyRequestDto withPhone(String value) {
    String newValue = Objects.requireNonNull(value, "phone");
    if (this.phone.equals(newValue)) return this;
    return new ImmutablePrivacyRequestDto(newValue, this.email, this.companyId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PrivacyRequestDto#email() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePrivacyRequestDto withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutablePrivacyRequestDto(this.phone, newValue, this.companyId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PrivacyRequestDto#companyId() companyId} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for companyId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePrivacyRequestDto withCompanyId(long value) {
    if (this.companyId == value) return this;
    return new ImmutablePrivacyRequestDto(this.phone, this.email, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePrivacyRequestDto} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePrivacyRequestDto
        && equalTo(0, (ImmutablePrivacyRequestDto) another);
  }

  private boolean equalTo(int synthetic, ImmutablePrivacyRequestDto another) {
    return phone.equals(another.phone)
        && email.equals(another.email)
        && companyId == another.companyId;
  }

  /**
   * Computes a hash code from attributes: {@code phone}, {@code email}, {@code companyId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + phone.hashCode();
    h += (h << 5) + email.hashCode();
    h += (h << 5) + Longs.hashCode(companyId);
    return h;
  }

  /**
   * Prints the immutable value {@code PrivacyRequestDto} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("PrivacyRequestDto")
        .omitNullValues()
        .add("phone", phone)
        .add("email", email)
        .add("companyId", companyId)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PrivacyRequestDto", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements PrivacyRequestDto {
    @Nullable String phone;
    @Nullable String email;
    long companyId;
    boolean companyIdIsSet;
    @JsonProperty("phone")
    public void setPhone(String phone) {
      this.phone = phone;
    }
    @JsonProperty("email")
    public void setEmail(String email) {
      this.email = email;
    }
    @JsonProperty("companyId")
    public void setCompanyId(long companyId) {
      this.companyId = companyId;
      this.companyIdIsSet = true;
    }
    @Override
    public String phone() { throw new UnsupportedOperationException(); }
    @Override
    public String email() { throw new UnsupportedOperationException(); }
    @Override
    public long companyId() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePrivacyRequestDto fromJson(Json json) {
    ImmutablePrivacyRequestDto.Builder builder = ImmutablePrivacyRequestDto.builder();
    if (json.phone != null) {
      builder.phone(json.phone);
    }
    if (json.email != null) {
      builder.email(json.email);
    }
    if (json.companyIdIsSet) {
      builder.companyId(json.companyId);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link PrivacyRequestDto} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PrivacyRequestDto instance
   */
  public static ImmutablePrivacyRequestDto copyOf(PrivacyRequestDto instance) {
    if (instance instanceof ImmutablePrivacyRequestDto) {
      return (ImmutablePrivacyRequestDto) instance;
    }
    return ImmutablePrivacyRequestDto.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePrivacyRequestDto ImmutablePrivacyRequestDto}.
   * <pre>
   * ImmutablePrivacyRequestDto.builder()
   *    .phone(String) // required {@link PrivacyRequestDto#phone() phone}
   *    .email(String) // required {@link PrivacyRequestDto#email() email}
   *    .companyId(long) // required {@link PrivacyRequestDto#companyId() companyId}
   *    .build();
   * </pre>
   * @return A new ImmutablePrivacyRequestDto builder
   */
  public static ImmutablePrivacyRequestDto.Builder builder() {
    return new ImmutablePrivacyRequestDto.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePrivacyRequestDto ImmutablePrivacyRequestDto}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PrivacyRequestDto", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder implements PrivacyRequestDto.Builder {
    private static final long INIT_BIT_PHONE = 0x1L;
    private static final long INIT_BIT_EMAIL = 0x2L;
    private static final long INIT_BIT_COMPANY_ID = 0x4L;
    private long initBits = 0x7L;

    private @Nullable String phone;
    private @Nullable String email;
    private long companyId;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PrivacyRequestDto} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PrivacyRequestDto instance) {
      Objects.requireNonNull(instance, "instance");
      phone(instance.phone());
      email(instance.email());
      companyId(instance.companyId());
      return this;
    }

    /**
     * Initializes the value for the {@link PrivacyRequestDto#phone() phone} attribute.
     * @param phone The value for phone 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("phone")
    public final Builder phone(String phone) {
      this.phone = Objects.requireNonNull(phone, "phone");
      initBits &= ~INIT_BIT_PHONE;
      return this;
    }

    /**
     * Initializes the value for the {@link PrivacyRequestDto#email() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("email")
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Initializes the value for the {@link PrivacyRequestDto#companyId() companyId} attribute.
     * @param companyId The value for companyId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("companyId")
    public final Builder companyId(long companyId) {
      this.companyId = companyId;
      initBits &= ~INIT_BIT_COMPANY_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePrivacyRequestDto ImmutablePrivacyRequestDto}.
     * @return An immutable instance of PrivacyRequestDto
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePrivacyRequestDto build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePrivacyRequestDto(phone, email, companyId);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_PHONE) != 0) attributes.add("phone");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      if ((initBits & INIT_BIT_COMPANY_ID) != 0) attributes.add("companyId");
      return "Cannot build PrivacyRequestDto, some of required attributes are not set " + attributes;
    }
  }
}
